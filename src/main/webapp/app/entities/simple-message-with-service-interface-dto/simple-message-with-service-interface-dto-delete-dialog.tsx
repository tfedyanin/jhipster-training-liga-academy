import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router-dom';
import { Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';
import { Translate, ICrudGetAction, ICrudDeleteAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { ISimpleMessageWithServiceInterfaceDto } from 'app/shared/model/simple-message-with-service-interface-dto.model';
import { IRootState } from 'app/shared/reducers';
import { getEntity, deleteEntity } from './simple-message-with-service-interface-dto.reducer';

export interface ISimpleMessageWithServiceInterfaceDtoDeleteDialogProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceInterfaceDtoDeleteDialog = (props: ISimpleMessageWithServiceInterfaceDtoDeleteDialogProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const handleClose = () => {
    props.history.push('/simple-message-with-service-interface-dto');
  };

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const confirmDelete = () => {
    props.deleteEntity(props.simpleMessageWithServiceInterfaceDtoEntity.id);
  };

  const { simpleMessageWithServiceInterfaceDtoEntity } = props;
  return (
    <Modal isOpen toggle={handleClose}>
      <ModalHeader toggle={handleClose}>
        <Translate contentKey="entity.delete.title">Confirm delete operation</Translate>
      </ModalHeader>
      <ModalBody id="jHipsterApp.simpleMessageWithServiceInterfaceDto.delete.question">
        <Translate
          contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDto.delete.question"
          interpolate={{ id: simpleMessageWithServiceInterfaceDtoEntity.id }}
        >
          Are you sure you want to delete this SimpleMessageWithServiceInterfaceDto?
        </Translate>
      </ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={handleClose}>
          <FontAwesomeIcon icon="ban" />
          &nbsp;
          <Translate contentKey="entity.action.cancel">Cancel</Translate>
        </Button>
        <Button id="jhi-confirm-delete-simpleMessageWithServiceInterfaceDto" color="danger" onClick={confirmDelete}>
          <FontAwesomeIcon icon="trash" />
          &nbsp;
          <Translate contentKey="entity.action.delete">Delete</Translate>
        </Button>
      </ModalFooter>
    </Modal>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterfaceDto }: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoEntity: simpleMessageWithServiceInterfaceDto.entity,
  updateSuccess: simpleMessageWithServiceInterfaceDto.updateSuccess
});

const mapDispatchToProps = { getEntity, deleteEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoDeleteDialog);
