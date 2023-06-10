import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

import Loader from "components/Loader";
import { getCollectionsForUser } from "api/users";
import placeholder from  "images/place_holder.png";
import CollectionCreateModal from "components/Collections/CollectionCreateModal";
import { postCollection } from "api/collections";

const params = {
    id: 2
  }

const UserDetails = () => {

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const [collections, setCollections] = useState();
    const [isCollectionsModalOpen, setIsCollectionsModalOpen] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        const fetch = async () => {
          try {
            setLoading(true);
            const response = await getCollectionsForUser(params.id);
            setCollections(response.collectionDTOS);
            setLoading(false);
          } catch (e) {
            setError("Unable to fetch collections!");
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


      const handleOpenCollectionsModal = () => {
        setIsCollectionsModalOpen(!isCollectionsModalOpen);
      };

      const handleCreateCollection = async (boardName, isPrivate) => {
        try {
          const data = {
            "name": boardName,
            "collectionVisibilityType": {
              "id": 1,
              "type": "PRIVATE"
            },
            "created_at": "2023-06-10",
            "numOfPosts": 0,
            "userId": 2,
            "deleted": false
          }
          
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
        {collections && (
          <div className="offset-1 col-md-9">
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
                      <button className="btn btn-light" onClick={() => handleItemClick(collection)}>
                        <img width="90px" style={{ margin: '5px' }} className="rounded" src={placeholder} alt={collection.name} />
                        <div className="text-secondary" style={{ width: '80px', textAlign: 'left' }}>{collection.name}</div>
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

export default UserDetails;