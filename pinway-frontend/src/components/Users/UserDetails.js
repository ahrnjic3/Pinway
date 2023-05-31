import React, { useEffect, useState } from "react";

import Loader from "components/Loader";
import { getCollectionsForUser } from "api/users";

const params = {
    id: 1
  }

const UserDetails = () => {

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const [collections, setCollections] = useState();

    useEffect(() => {
        const fetch = async () => {
          try {
            setLoading(true);
            const response = await getCollectionsForUser(params.id);
            setCollections(response.collectionDTOS);
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
    );}

    return (
        <div>
            <Loader isLoading={loading} />
            {collections && (
                <div className="offset-1 col-md-9" >
                    <div className="card border-0">
                        <div className="text-secondary">
                            Collections
                        </div>
                        <div className="row">
                            <div className="card-body" style={{ border: '2px solid lightgrey', borderRadius: '10px' }}>
                                <div className="col-md-4">
                                    {collections.map((collection) => (
                                            <p key={collection.id}>{collection.name}</p>
                                    ))}
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