import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router-dom';
import { Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';
import { Translate, ICrudGetAction, ICrudDeleteAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering } from 'app/shared/model/simple-message-with-service-interface-dto-infinity-scroll-filtering.model';
import { IRootState } from 'app/shared/reducers';
import { getEntity, deleteEntity } from './simple-message-with-service-interface-dto-infinity-scroll-filtering.reducer';

export interface ISimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDeleteDialogProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDeleteDialog = (
  props: ISimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDeleteDialogProps
) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const handleClose = () => {
    props.history.push('/simple-message-with-service-interface-dto-infinity-scroll-filtering');
  };

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const confirmDelete = () => {
    props.deleteEntity(props.simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringEntity.id);
  };

  const { simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringEntity } = props;
  return (
    <Modal isOpen toggle={handleClose}>
      <ModalHeader toggle={handleClose}>
        <Translate contentKey="entity.delete.title">Confirm delete operation</Translate>
      </ModalHeader>
      <ModalBody id="jHipsterApp.simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.delete.question">
        <Translate
          contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.delete.question"
          interpolate={{ id: simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringEntity.id }}
        >
          Are you sure you want to delete this SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering?
        </Translate>
      </ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={handleClose}>
          <FontAwesomeIcon icon="ban" />
          &nbsp;
          <Translate contentKey="entity.action.cancel">Cancel</Translate>
        </Button>
        <Button id="jhi-confirm-delete-simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering" color="danger" onClick={confirmDelete}>
          <FontAwesomeIcon icon="trash" />
          &nbsp;
          <Translate contentKey="entity.action.delete">Delete</Translate>
        </Button>
      </ModalFooter>
    </Modal>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering }: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringEntity: simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.entity,
  updateSuccess: simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.updateSuccess
});

const mapDispatchToProps = { getEntity, deleteEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDeleteDialog);
