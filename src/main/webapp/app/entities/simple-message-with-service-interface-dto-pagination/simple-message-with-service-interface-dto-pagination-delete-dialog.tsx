import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router-dom';
import { Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';
import { Translate, ICrudGetAction, ICrudDeleteAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { ISimpleMessageWithServiceInterfaceDtoPagination } from 'app/shared/model/simple-message-with-service-interface-dto-pagination.model';
import { IRootState } from 'app/shared/reducers';
import { getEntity, deleteEntity } from './simple-message-with-service-interface-dto-pagination.reducer';

export interface ISimpleMessageWithServiceInterfaceDtoPaginationDeleteDialogProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceInterfaceDtoPaginationDeleteDialog = (
  props: ISimpleMessageWithServiceInterfaceDtoPaginationDeleteDialogProps
) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const handleClose = () => {
    props.history.push('/simple-message-with-service-interface-dto-pagination' + props.location.search);
  };

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const confirmDelete = () => {
    props.deleteEntity(props.simpleMessageWithServiceInterfaceDtoPaginationEntity.id);
  };

  const { simpleMessageWithServiceInterfaceDtoPaginationEntity } = props;
  return (
    <Modal isOpen toggle={handleClose}>
      <ModalHeader toggle={handleClose}>
        <Translate contentKey="entity.delete.title">Confirm delete operation</Translate>
      </ModalHeader>
      <ModalBody id="jHipsterApp.simpleMessageWithServiceInterfaceDtoPagination.delete.question">
        <Translate
          contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoPagination.delete.question"
          interpolate={{ id: simpleMessageWithServiceInterfaceDtoPaginationEntity.id }}
        >
          Are you sure you want to delete this SimpleMessageWithServiceInterfaceDtoPagination?
        </Translate>
      </ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={handleClose}>
          <FontAwesomeIcon icon="ban" />
          &nbsp;
          <Translate contentKey="entity.action.cancel">Cancel</Translate>
        </Button>
        <Button id="jhi-confirm-delete-simpleMessageWithServiceInterfaceDtoPagination" color="danger" onClick={confirmDelete}>
          <FontAwesomeIcon icon="trash" />
          &nbsp;
          <Translate contentKey="entity.action.delete">Delete</Translate>
        </Button>
      </ModalFooter>
    </Modal>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterfaceDtoPagination }: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoPaginationEntity: simpleMessageWithServiceInterfaceDtoPagination.entity,
  updateSuccess: simpleMessageWithServiceInterfaceDtoPagination.updateSuccess
});

const mapDispatchToProps = { getEntity, deleteEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoPaginationDeleteDialog);
