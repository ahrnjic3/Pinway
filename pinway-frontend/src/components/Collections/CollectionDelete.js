import React from 'react';

function CollectionDelete({ visible, handleClick, handleDelete }) {
  const handleCloseModal = () => {
    handleClick();
  };

  const onApply = () => {
    handleDelete();
  };

  return (
    <div>
      <div className={`modal${visible ? ' show' : ''}`} tabIndex="-1" role="dialog" style={{ display: visible ? 'block' : 'none' }}>
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">Modal Title</h5>
                <button type="button" className="close" onClick={handleCloseModal}>
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                <p>Modal content goes here...</p>
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-secondary" onClick={handleCloseModal}>
                  Close
                </button>
                <button type="button" className="btn btn-primary" onClick={onApply}>
                  Save changes
                </button>
              </div>
            </div>
          </div>
        </div>
    </div>
  );
}



export default CollectionDelete;