import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";

import { getVisibleCollectionsForUser, getFollowersForUser, getUserById } from "api/users";
import { getPostsForUser } from "api/posts";

import monkey from  "images/monkey.png";
import collections_place_holder from "images/collections_place_holder.jpg";
import placeholder from  "images/place_holder.png";

import Loader from "components/Loader";

const UserDetails = () => {

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const [collections, setCollections] = useState();
    const [posts, setPosts] = useState();
    const [followers, setFollowers] = useState();
    const [user, setUser] = useState();

    const navigate = useNavigate();
    const location = useLocation();
    const { id } = location.state;

    const [isVisible, setIsVisible] = useState(false);

    useEffect(() => {
        const fetch = async () => {
          try {
            setLoading(true);
            const data = {
              "userId": id,
              "actionUserId": parseInt(localStorage.getItem("UserId"))
            };
            console.log("Hello: ", data);
            const responseUser = await getUserById(id);
            const responseCollections = await getVisibleCollectionsForUser(data);
            //const responseCollections = await getCollectionsForUser(id);
            const responsePosts = await getPostsForUser(id);
            const responseFollowers = await getFollowersForUser(id);

            setUser(responseUser);
            setCollections(responseCollections);
            setPosts(responsePosts);
            setFollowers(responseFollowers);
            
            
            const containsId = responseFollowers.some(obj => obj.id === parseInt(localStorage.getItem("UserId")));
            if(containsId !== true)
              setIsVisible(true);

            setLoading(false);
          } catch (e) {
            setError("Unable to fetch User Details!");
          } finally {
            setLoading(false);
          }
        };
    
        fetch();
      }, []);

      const handleItemClick = async (item) => {
        // Handle item click event
        console.log(`Clicked ${item.id}`);
        const id = item.id;
        const userId = user.id;
        navigate("/collections/user/details", { state: { id, userId } });
      };

      const handlePostClick = async (item) => {
        // Handle item click event
        console.log(`Clicked ${item.id}`);
        const id = item.id;
        navigate("/posts/details", { state: { id } });
      };

    

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
        <Loader isLoading={loading} />
        {user && posts && collections && (
          <div>
        {/* user  */}
          <div className="offset-1 col-md-9 text-center mx-auto">
            <img src={monkey} alt="" className="d-inline-block align-text-top" />
            <div style={{ margin: '0.5rem 0' }}>
              <div style={{ fontSize: '1.2rem' }}>{user.name} {user.surname}</div>
              <div className="text-secondary">@{user.username}</div>
              <div style={{ fontSize: '0.9rem' }}>
                {followers.length} follower {user.following.length} following
              </div>
            </div>
            <button 
              className="btn rounded" 
              style={{ display: isVisible ? 'inline' : 'none', backgroundColor: '#d7a8f8', color: 'white' }}
            >Follow</button>
          </div>

        {/* collections  */}
          <div className="offset-1 col-md-9 mx-auto">
            <div className="card border-0">
              <div className="d-flex align-items-center justify-content-between">
                <div className="text-secondary">Collections</div>
              </div>

              <div className="row">
                <div className="card-body" style={{ border: '2px solid lightgrey', borderRadius: '10px', display: 'flex', gap: '5px', flexWrap: 'wrap' }}>
                {collections.length === 0 ? (
                  <div style={{ margin: 'auto',  width: '100%', height: '100%'}}>
                    <div style={{ color:'grey', textAlign: 'center' }}>There aren't any Collections yet.</div>
                  </div>
                  ) : (
                  <div>
                    {collections.map((collection) => (
                      <div key={collection.id} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', flexBasis: '16%' }}>
                        <button style={{ backgroundColor: '#f6f4f5' }} className="btn btn-light" onClick={() => handleItemClick(collection)}>
                          <img width="90px" style={{ margin: '5px' }} className="rounded" src={collections_place_holder} alt={collection.name} />
                          <div className="text-secondary" style={{ width: '90px', textAlign: 'left' }}>{collection.name}</div>
                        </button>
                      </div>
                    ))}
                  </div>
                  )}
                </div>
              </div>
            </div>
          </div>

        {/* posts */}
          <div className="offset-1 col-md-9 mx-auto">
            <div className="card border-0">
              <div className="d-flex align-items-center justify-content-between">
                <div className="text-secondary">Posts</div>
              </div>
              <div className="row">
                <div className="card-body" style={{ border: '2px solid lightgrey', borderRadius: '10px', display: 'flex', gap: '5px', flexWrap: 'wrap' }}>
                {posts.length === 0 ? (
                  <div style={{ margin: 'auto',  width: '100%', height: '100%'}}>
                    <div style={{ color:'grey', textAlign: 'center' }}>There aren't any Posts yet.</div>
                  </div>
                  ) : (
                  <div>
                    {posts.map((post) => (
                        <div key={post.id} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', flexBasis: '16%' }}>
                          <button style={{ backgroundColor: '#f6f4f5' }} className="btn btn-light" onClick={() => handlePostClick(post)}>
                            <img width="100%" className="rounded" src={"http://localhost:8080/post-photos/" + post.id + "/" + post.image_path} alt={placeholder} />
                          </button>
                        </div>
                      ))}
                  </div>
                  )}
                </div>
              </div>
            </div>
          </div>
        </div>
        )}            
      </div>

    
    )
};

export default UserDetails;