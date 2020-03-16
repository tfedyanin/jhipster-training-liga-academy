import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router-dom';
import { Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';
import { Translate, ICrudGetAction, ICrudDeleteAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { ISimpleMessageWithServiceInterface } from 'app/shared/model/simple-message-with-service-interface.model';
import { IRootState } from 'app/shared/reducers';
import { getEntity, deleteEntity } from './simple-message-with-service-interface.reducer';

export interface ISimpleMessageWithServiceInterfaceDeleteDialogProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceInterfaceDeleteDialog = (props: ISimpleMessageWithServiceInterfaceDeleteDialogProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const handleClose = () => {
    props.history.push('/simple-message-with-service-interface');
  };

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const confirmDelete = () => {
    props.deleteEntity(props.simpleMessageWithServiceInterfaceEntity.id);
  };

  const { simpleMessageWithServiceInterfaceEntity } = props;
  return (
    <Modal isOpen toggle={handleClose}>
      <ModalHeader toggle={handleClose}>
        <Translate contentKey="entity.delete.title">Confirm delete operation</Translate>
      </ModalHeader>
      <ModalBody id="jHipsterApp.simpleMessageWithServiceInterface.delete.question">
        <Translate
          contentKey="jHipsterApp.simpleMessageWithServiceInterface.delete.question"
          interpolate={{ id: simpleMessageWithServiceInterfaceEntity.id }}
        >
          Are you sure you want to delete this SimpleMessageWithServiceInterface?
        </Translate>
      </ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={handleClose}>
          <FontAwesomeIcon icon="ban" />
          &nbsp;
          <Translate contentKey="entity.action.cancel">Cancel</Translate>
        </Button>
        <Button id="jhi-confirm-delete-simpleMessageWithServiceInterface" color="danger" onClick={confirmDelete}>
          <FontAwesomeIcon icon="trash" />
          &nbsp;
          <Translate contentKey="entity.action.delete">Delete</Translate>
        </Button>
      </ModalFooter>
    </Modal>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterface }: IRootState) => ({
  simpleMessageWithServiceInterfaceEntity: simpleMessageWithServiceInterface.entity,
  updateSuccess: simpleMessageWithServiceInterface.updateSuccess
});

const mapDispatchToProps = { getEntity, deleteEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDeleteDialog);
