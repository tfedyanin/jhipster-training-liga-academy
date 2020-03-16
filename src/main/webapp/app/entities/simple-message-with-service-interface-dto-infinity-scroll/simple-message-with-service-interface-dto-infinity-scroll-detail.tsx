import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './simple-message-with-service-interface-dto-infinity-scroll.reducer';
import { ISimpleMessageWithServiceInterfaceDtoInfinityScroll } from 'app/shared/model/simple-message-with-service-interface-dto-infinity-scroll.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISimpleMessageWithServiceInterfaceDtoInfinityScrollDetailProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceInterfaceDtoInfinityScrollDetail = (
  props: ISimpleMessageWithServiceInterfaceDtoInfinityScrollDetailProps
) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { simpleMessageWithServiceInterfaceDtoInfinityScrollEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoInfinityScroll.detail.title">
            SimpleMessageWithServiceInterfaceDtoInfinityScroll
          </Translate>{' '}
          [<b>{simpleMessageWithServiceInterfaceDtoInfinityScrollEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details"></dl>
        <Button tag={Link} to="/simple-message-with-service-interface-dto-infinity-scroll" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button
          tag={Link}
          to={`/simple-message-with-service-interface-dto-infinity-scroll/${simpleMessageWithServiceInterfaceDtoInfinityScrollEntity.id}/edit`}
          replace
          color="primary"
        >
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterfaceDtoInfinityScroll }: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoInfinityScrollEntity: simpleMessageWithServiceInterfaceDtoInfinityScroll.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoInfinityScrollDetail);
