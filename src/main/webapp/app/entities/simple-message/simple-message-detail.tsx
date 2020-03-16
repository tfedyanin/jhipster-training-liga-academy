import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './simple-message.reducer';
import { ISimpleMessage } from 'app/shared/model/simple-message.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISimpleMessageDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const SimpleMessageDetail = (props: ISimpleMessageDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { simpleMessageEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jHipsterApp.simpleMessage.detail.title">SimpleMessage</Translate> [<b>{simpleMessageEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="msg">
              <Translate contentKey="jHipsterApp.simpleMessage.msg">Msg</Translate>
            </span>
          </dt>
          <dd>{simpleMessageEntity.msg}</dd>
        </dl>
        <Button tag={Link} to="/simple-message" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/simple-message/${simpleMessageEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ simpleMessage }: IRootState) => ({
  simpleMessageEntity: simpleMessage.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageDetail);
