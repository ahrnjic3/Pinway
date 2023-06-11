import React from 'react';
import '../style/UserPage.css';
import userPlaceholder from 'images/place_holder.png';
import collectionImage1 from 'images/place_holder.png';
import collectionImage2 from 'images/place_holder.png';
import collectionImage3 from 'images/place_holder.png';

class UserProfile extends React.Component {
  render() {
    return (
      <div className="user-page">
        <div className="user-content">
          <div className="profile-section">
            <div className="profile-card">
              <div className="profile-info">
                <div className="profile-photo">
                  <img src={userPlaceholder} alt="User" />
                </div>
                <div className="profile-details">
                  <h3>User User</h3>
                  <p>Email: user@etf.unsa.ba</p>
                  <p>Username: userS</p>
                </div>
              </div>
              <div className="profile-stats">
                <div className="stat">
                  <h4>Followers</h4>
                  <p>100</p>
                </div>
                <div className="stat">
                  <h4>Following</h4>
                  <p>50</p>
                </div>
                <div className="stat">
                  <h4>Posts</h4>
                  <p>200</p>
                </div>
              </div>
              <button className="edit-profile-button">Edit Profile</button>
            </div>
          </div>
          <div className="collections-section">
            <h3>My Collections</h3>
            <div className="collections">
              <div className="collection-card">
                <img src={collectionImage1} alt="Collection 1" />
                <h4>Collection 1</h4>
              </div>
              <div className="collection-card">
                <img src={collectionImage2} alt="Collection 2" />
                <h4>Collection 2</h4>
              </div>
              <div className="collection-card">
                <img src={collectionImage3} alt="Collection 3" />
                <h4>Collection 3</h4>
              </div>
            </div>
          </div>
        </div>

        <div className="section-title">
            <h3>Popular</h3>
        </div>


        <div className="hashtag-posts">
          <div className="hashtag-row">
            <div className="hashtag-post">
            <div className="hashtag-info">
                            <h4>#travel</h4>
                            <p>1234 Posts</p>
                          </div>
              <img src={collectionImage1} alt="Post" />
              <img src={collectionImage1} alt="Post" />
              <img src={collectionImage1} alt="Post" />
              <img src={collectionImage1} alt="Post" />
              <img src={collectionImage1} alt="Post" />
              <img src={collectionImage1} alt="Post" />
              <img src={collectionImage1} alt="Post" />
              <img src={collectionImage1} alt="Post" />



            </div>
            <div className="hashtag-post">
              <div className="hashtag-info">
                            <h4>#food</h4>
                            <p>5678 Posts</p>
                          </div>
              <img src={collectionImage2} alt="Post" />
              <img src={collectionImage2} alt="Post" />
              <img src={collectionImage2} alt="Post" />
              <img src={collectionImage2} alt="Post" />
              <img src={collectionImage2} alt="Post" />
              <img src={collectionImage2} alt="Post" />
              <img src={collectionImage2} alt="Post" />

              <img src={collectionImage2} alt="Post" />



            </div>
            <div className="hashtag-post">
            <div className="hashtag-info">
                            <h4>#fashion</h4>
                            <p>9012 Posts</p>
                          </div>
              <img src={collectionImage3} alt="Post" />
              <img src={collectionImage3} alt="Post" />
              <img src={collectionImage3} alt="Post" />
              <img src={collectionImage3} alt="Post" />
              <img src={collectionImage3} alt="Post" />
              <img src={collectionImage3} alt="Post" />
              <img src={collectionImage3} alt="Post" />
              <img src={collectionImage3} alt="Post" />
            </div>
          </div>
          <div className="hashtag-row">
            {/* Add more hashtag posts for the second row */}
          </div>
          <div className="hashtag-row">
            {/* Add more hashtag posts for the third row */}
          </div>
        </div>

      </div>
    );
  }
}

export default UserProfile;
