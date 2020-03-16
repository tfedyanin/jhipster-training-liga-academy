import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './simple-message-with-service-interface-dto-infinity-scroll.reducer';
import { ISimpleMessageWithServiceInterfaceDtoInfinityScroll } from 'app/shared/model/simple-message-with-service-interface-dto-infinity-scroll.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ISimpleMessageWithServiceInterfaceDtoInfinityScrollUpdateProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceInterfaceDtoInfinityScrollUpdate = (
  props: ISimpleMessageWithServiceInterfaceDtoInfinityScrollUpdateProps
) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { simpleMessageWithServiceInterfaceDtoInfinityScrollEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/simple-message-with-service-interface-dto-infinity-scroll');
  };

  useEffect(() => {
    if (!isNew) {
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
        ...simpleMessageWithServiceInterfaceDtoInfinityScrollEntity,
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
          <h2 id="jHipsterApp.simpleMessageWithServiceInterfaceDtoInfinityScroll.home.createOrEditLabel">
            <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoInfinityScroll.home.createOrEditLabel">
              Create or edit a SimpleMessageWithServiceInterfaceDtoInfinityScroll
            </Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : simpleMessageWithServiceInterfaceDtoInfinityScrollEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="simple-message-with-service-interface-dto-infinity-scroll-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput
                    id="simple-message-with-service-interface-dto-infinity-scroll-id"
                    type="text"
                    className="form-control"
                    name="id"
                    required
                    readOnly
                  />
                </AvGroup>
              ) : null}
              <Button tag={Link} id="cancel-save" to="/simple-message-with-service-interface-dto-infinity-scroll" replace color="info">
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
  simpleMessageWithServiceInterfaceDtoInfinityScrollEntity: storeState.simpleMessageWithServiceInterfaceDtoInfinityScroll.entity,
  loading: storeState.simpleMessageWithServiceInterfaceDtoInfinityScroll.loading,
  updating: storeState.simpleMessageWithServiceInterfaceDtoInfinityScroll.updating,
  updateSuccess: storeState.simpleMessageWithServiceInterfaceDtoInfinityScroll.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoInfinityScrollUpdate);
