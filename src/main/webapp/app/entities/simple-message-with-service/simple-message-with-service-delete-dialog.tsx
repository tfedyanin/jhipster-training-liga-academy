import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router-dom';
import { Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';
import { Translate, ICrudGetAction, ICrudDeleteAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { ISimpleMessageWithService } from 'app/shared/model/simple-message-with-service.model';
import { IRootState } from 'app/shared/reducers';
import { getEntity, deleteEntity } from './simple-message-with-service.reducer';

export interface ISimpleMessageWithServiceDeleteDialogProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceDeleteDialog = (props: ISimpleMessageWithServiceDeleteDialogProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const handleClose = () => {
    props.history.push('/simple-message-with-service');
  };

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const confirmDelete = () => {
    props.deleteEntity(props.simpleMessageWithServiceEntity.id);
  };

  const { simpleMessageWithServiceEntity } = props;
  return (
    <Modal isOpen toggle={handleClose}>
      <ModalHeader toggle={handleClose}>
        <Translate contentKey="entity.delete.title">Confirm delete operation</Translate>
      </ModalHeader>
      <ModalBody id="jHipsterApp.simpleMessageWithService.delete.question">
        <Translate
          contentKey="jHipsterApp.simpleMessageWithService.delete.question"
          interpolate={{ id: simpleMessageWithServiceEntity.id }}
        >
          Are you sure you want to delete this SimpleMessageWithService?
        </Translate>
      </ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={handleClose}>
          <FontAwesomeIcon icon="ban" />
          &nbsp;
          <Translate contentKey="entity.action.cancel">Cancel</Translate>
        </Button>
        <Button id="jhi-confirm-delete-simpleMessageWithService" color="danger" onClick={confirmDelete}>
          <FontAwesomeIcon icon="trash" />
          &nbsp;
          <Translate contentKey="entity.action.delete">Delete</Translate>
        </Button>
      </ModalFooter>
    </Modal>
  );
};

const mapStateToProps = ({ simpleMessageWithService }: IRootState) => ({
  simpleMessageWithServiceEntity: simpleMessageWithService.entity,
  updateSuccess: simpleMessageWithService.updateSuccess
});

const mapDispatchToProps = { getEntity, deleteEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceDeleteDialog);
