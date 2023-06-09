import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";


import { getPostsForCollection, deleteCollection } from "api/collections";
import Loader from "components/Loader";
import CollectionDelete from "components/Collections/CollectionDelete";

import placeholder from  "images/place_holder.png";

const params = {
  id: 1
}

const Collections = () => {

    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    const [data, setData] = useState();
    const [posts, setPosts] = useState();
    const [modal, setModal] = useState(false);

    const navigate = useNavigate();

    const handleClick = () => {
      setModal(!modal);
    };

    const handleDelete = async () => {
      try {
        await deleteCollection(params.id);
        toast.success("Collection deleted!");
        navigate("/users/");
      } catch (err) {
        toast.error("Unable to delete collection!");
      } finally {
        setModal(!modal);
      }
    };

    useEffect(() => {
        const fetch = async () => {
          try {
            setLoading(true);
            const response = await getPostsForCollection(params.id);
            setData(response.collectionDTO);
            setPosts(response.postDTO);
          } catch (e) {
            setError("Unable to fetch collections!");
          } finally {
            setLoading(false);
          }
        };

        fetch();
      }, [params.id]);

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
          {/* <CollectionDelete show={modal} handleClick={handleClick} handleDelete={handleDelete}></CollectionDelete> */}
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
                          <button className="btn btn-light text-secondary mb-1 btn-sm">Share</button>
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
                    <img key={post.id} width="150" height="150" className = "rounded" src={placeholder} alt={post.name} style={{ margin: '10px' }}></img>
                  ))}
              </div>
            </div>
          )}
        </div>
    )
};

export default Collections;