import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './simple-message-with-service-interface-dto-pagination.reducer';
import { ISimpleMessageWithServiceInterfaceDtoPagination } from 'app/shared/model/simple-message-with-service-interface-dto-pagination.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ISimpleMessageWithServiceInterfaceDtoPaginationUpdateProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceInterfaceDtoPaginationUpdate = (props: ISimpleMessageWithServiceInterfaceDtoPaginationUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { simpleMessageWithServiceInterfaceDtoPaginationEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/simple-message-with-service-interface-dto-pagination' + props.location.search);
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const entity = {
        ...simpleMessageWithServiceInterfaceDtoPaginationEntity,
        ...values
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="jHipsterApp.simpleMessageWithServiceInterfaceDtoPagination.home.createOrEditLabel">
            <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoPagination.home.createOrEditLabel">
              Create or edit a SimpleMessageWithServiceInterfaceDtoPagination
            </Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : simpleMessageWithServiceInterfaceDtoPaginationEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="simple-message-with-service-interface-dto-pagination-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput
                    id="simple-message-with-service-interface-dto-pagination-id"
                    type="text"
                    className="form-control"
                    name="id"
                    required
                    readOnly
                  />
                </AvGroup>
              ) : null}
              <Button tag={Link} id="cancel-save" to="/simple-message-with-service-interface-dto-pagination" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoPaginationEntity: storeState.simpleMessageWithServiceInterfaceDtoPagination.entity,
  loading: storeState.simpleMessageWithServiceInterfaceDtoPagination.loading,
  updating: storeState.simpleMessageWithServiceInterfaceDtoPagination.updating,
  updateSuccess: storeState.simpleMessageWithServiceInterfaceDtoPagination.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoPaginationUpdate);
