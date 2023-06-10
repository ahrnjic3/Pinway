import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { useNavigate, useLocation  } from "react-router-dom";


import { getPostsForCollection, deleteCollection } from "api/collections";
import { getFollowersForUser, addUserToCollection } from "api/users";
import Loader from "components/Loader";
import CollectionDelete from "components/Collections/CollectionDelete";

import placeholder from  "images/place_holder.png";

const params = {
  userId: 1
}


const Collections = ({collection}) => {

    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    const [data, setData] = useState();
    const [posts, setPosts] = useState();
    const [followers, setFollowers] = useState();
    const [modal, setModal] = useState(false);

    const getRandomHeight = () => Math.floor(Math.random() * 31) + 190;

    const navigate = useNavigate();
    const location = useLocation();
    const { id } = location.state;

    const handleClick = () => {
      setModal(!modal);
    };

    const handleDelete = async () => {
      try {
        await deleteCollection(id);
        toast.success("Collection deleted!");
        navigate("/users/");
      } catch (err) {
        toast.error("Unable to delete collection!");
      } finally {
        setModal(!modal);
      }
    };

    const handleItemClick = async (item) => {
      // Handle item click event
      console.log(`Clicked ${item.id}`);
      try {
        const data = {
          collectionId: 1
        };
        await addUserToCollection(item.id, data);
        toast.success("Collection shared!");
      } catch (e) {
        setError("Unable to share collection!");
      }
    };

    useEffect(() => {
        const fetch = async () => {
          try {
            setLoading(true);
            const response = await getPostsForCollection(id);
            // followers
            const followers = await getFollowersForUser(params.userId);
            setData(response.collectionDTO);
            setPosts(response.postDTO);
            setFollowers(followers);
          } catch (e) {
            setError("Unable to fetch collections!");
          } finally {
            setLoading(false);
          }
        };
    
        fetch();
      }, [id]);

    if (error) {
      return (
        <div className="container offset-2 col-8" style={{padding: '15px'}}>
          <div className="alert alert-danger" role="alert">
            {error}
          </div>
        </div>
      );
    }

    return (
        <div className="container" style={{padding: '20px'}}>
          <CollectionDelete visible={modal} handleClick={handleClick} handleDelete={handleDelete}></CollectionDelete>
          <Loader isLoading={loading} />
          {posts && (
            <div className="row">
              <div className="col-md-3 h-25">
                <div className="row">
                  <div className="container rounded offset-2 col-8 p-4" style={{ backgroundColor: '#d7a8f5' }}>
                    <div className="row">
                      <div className="col-md-12 text-center mb-3">
                        <button className="btn btn-light">{data.name}</button>
                      </div>
                    </div>
                    <div className="row">
                        <div className="col-md-6 text-center">
                        <div className="dropdown">
                          <button className="btn btn-light text-secondary mb-1 btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Share
                          </button>
                          <div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            {followers.map((follower) => (
                              <button
                                key={follower.id}
                                className="dropdown-item"
                                type="button"
                                onClick={() => handleItemClick(follower)}
                              >
                               {`${follower.name} ${follower.surname}`}
                              </button>
                            ))}
                          </div>
                        </div>
                          {/* <button className="btn btn-light text-secondary mb-1 btn-sm">Share</button> */}
                        </div>
                        <div className="col-md-6 text-center">
                          <button className="btn btn-light text-secondary mb-1 btn-sm" onClick={handleClick}>Delete</button>
                        </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="col-md-9" style={{ border: '2px solid lightgrey', borderRadius: '10px', padding: "15px" }}>
                  {posts.map((post) => (
                      <img key={post.id} width="180" style={{ height: getRandomHeight(), margin: '10px' }} className = "rounded" src={"http://localhost:8080/post-photos/" + post.id + "/" + post.image_path} alt={placeholder} ></img>
                  ))}
              </div>
            </div>
          )}
        </div>
    )
};

export default Collections;