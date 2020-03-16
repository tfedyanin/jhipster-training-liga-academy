import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './simple-message-with-service-interface-dto-pagination.reducer';
import { ISimpleMessageWithServiceInterfaceDtoPagination } from 'app/shared/model/simple-message-with-service-interface-dto-pagination.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISimpleMessageWithServiceInterfaceDtoPaginationDetailProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ id: string }> {}

export const SimpleMessageWithServiceInterfaceDtoPaginationDetail = (props: ISimpleMessageWithServiceInterfaceDtoPaginationDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { simpleMessageWithServiceInterfaceDtoPaginationEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoPagination.detail.title">
            SimpleMessageWithServiceInterfaceDtoPagination
          </Translate>{' '}
          [<b>{simpleMessageWithServiceInterfaceDtoPaginationEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details"></dl>
        <Button tag={Link} to="/simple-message-with-service-interface-dto-pagination" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button
          tag={Link}
          to={`/simple-message-with-service-interface-dto-pagination/${simpleMessageWithServiceInterfaceDtoPaginationEntity.id}/edit`}
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

const mapStateToProps = ({ simpleMessageWithServiceInterfaceDtoPagination }: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoPaginationEntity: simpleMessageWithServiceInterfaceDtoPagination.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoPaginationDetail);
