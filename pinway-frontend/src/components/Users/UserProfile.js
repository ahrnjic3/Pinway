import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

import Loader from "components/Loader";
import { getCollectionsForUser, getUserById } from "api/users";
import { getPostsForUser } from "api/posts";
import placeholder from  "images/place_holder.png";
import monkey from  "images/monkey.png";
import collections_place_holder from "images/collections_place_holder.jpg";
import CollectionCreateModal from "components/Collections/CollectionCreateModal";
import { postCollection } from "api/collections";

const UserProfile = () => {

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const [collections, setCollections] = useState();
    const [posts, setPosts] = useState();
    const [user, setUser] = useState();
    const [isCollectionsModalOpen, setIsCollectionsModalOpen] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        const fetch = async () => {
          try {
            setLoading(true);
            const responseUser = await getUserById(localStorage.getItem("UserId"));
            const response = await getCollectionsForUser(localStorage.getItem("UserId"));
            const responsePosts = await getPostsForUser(localStorage.getItem("UserId"));
            setUser(responseUser);
            setCollections(response.collectionDTOS);
            setPosts(responsePosts);
            setLoading(false);
          } catch (e) {
            setError("Unable to fetch User Details!");
          } finally {
            setLoading(false);
          }
        };
    
        fetch();
      }, [isCollectionsModalOpen]);

      const handleItemClick = async (item) => {
        // Handle item click event
        console.log(`Clicked ${item.id}`);
        const id = item.id;
        navigate("/collections", { state: { id } });
      };

      const handlePostClick = async (item) => {
        // Handle item click event
        console.log(`Clicked ${item.id}`);
        const id = item.id;
        navigate("/posts/details", { state: { id } });
      };


      const handleOpenCollectionsModal = () => {
        setIsCollectionsModalOpen(!isCollectionsModalOpen);
      };

      const handleCreatePost = () => {
        navigate("/posts/create");
      }

      const handleCreateCollection = async (boardName, isPrivate) => {
        try {
          let type = "PRIVATE";
          let id = 1;
          if(isPrivate !== true) {
            type = "PUBLIC";
            id = 2;
          }
          const data = {
            "name": boardName,
            "collectionVisibilityType": {
              "id": id,
              "type": type
            },
            "created_at": "",
            "numOfPosts": 0,
            "userId": localStorage.getItem("UserId"),
            "deleted": false
          }

          console.log(data);
          
          await postCollection(data);
          toast.success("Collection added!");
        } catch (e) {
          toast.error("Unable to add collection!");
        } finally {
          setIsCollectionsModalOpen(!isCollectionsModalOpen);
        }
        
      }
    

    if (error) {
    return (
        <div className="container offset-2 col-8" style={{padding: '15px'}}>
        <div className="alert alert-danger" role="alert">
            {error}
        </div>
        </div>
    );}

    return (
      <div>
        <CollectionCreateModal visible={isCollectionsModalOpen} handleClick={handleOpenCollectionsModal} handleCreateCollection={handleCreateCollection}></CollectionCreateModal>
        <Loader isLoading={loading} />
        {/* user  */}
        {user && (
          <div className="offset-1 col-md-9 text-center mx-auto">
            <img src={monkey} alt=""  className="d-inline-block align-text-top"></img>
            <div>{user.name} {user.surname}</div>
            <div>@{user.username}</div>
            <div className="text-secondary">{user.following.length} Following</div>
          </div>
        )}
        {/* collections  */}
        {collections && (
          <div className="offset-1 col-md-9 mx-auto">
            <div className="card border-0">
              <div className="d-flex align-items-center justify-content-between">
                <div className="text-secondary">Collections</div>
                <button className="btn btn-transparent" onClick={handleOpenCollectionsModal}>
                  <span style={{ color: 'grey', fontSize: '2.5rem' }}>+</span>
                </button>
              </div>
              <div className="row">
                <div className="card-body" style={{ border: '2px solid lightgrey', borderRadius: '10px', display: 'flex', gap: '5px', flexWrap: 'wrap' }}>
                  {collections.map((collection) => (
                    <div key={collection.id} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', flexBasis: '16%' }}>
                      <button style={{ backgroundColor: '#f6f4f5' }} className="btn btn-light" onClick={() => handleItemClick(collection)}>
                        <img width="90px" style={{ margin: '5px' }} className="rounded" src={collections_place_holder} alt={collection.name} />
                        <div className="text-secondary" style={{ width: '90px', textAlign: 'left' }}>{collection.name}</div>
                      </button>
                    </div>
                  ))}
                </div>
              </div>
            </div>
          </div>
        )}

        {/* posts */}
        {posts && (
          <div className="offset-1 col-md-9 mx-auto">
            <div className="card border-0">
              <div className="d-flex align-items-center justify-content-between">
                <div className="text-secondary">Posts</div>
                <button className="btn btn-transparent" onClick={handleCreatePost}>
                  <span style={{ color: 'grey', fontSize: '2.5rem' }}>+</span>
                </button>
              </div>
              <div className="row">
                <div className="card-body" style={{ border: '2px solid lightgrey', borderRadius: '10px', display: 'flex', gap: '5px', flexWrap: 'wrap' }}>
                  {posts.map((post) => (
                    <div key={post.id} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', flexBasis: '16%' }}>
                      <button style={{ backgroundColor: '#f6f4f5' }} className="btn btn-light" onClick={() => handlePostClick(post)}>
                        <img width="100%" className="rounded" src={"http://localhost:8080/post-photos/" + post.id + "/" + post.image_path} alt={placeholder} />
                      </button>
                    </div>
                  ))}
                </div>
              </div>
            </div>
          </div>
        )}

      </div>

    
    )
};

export default UserProfile;