import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './simple-message-with-service.reducer';
import { ISimpleMessageWithService } from 'app/shared/model/simple-message-with-service.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISimpleMessageWithServiceProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const SimpleMessageWithService = (props: ISimpleMessageWithServiceProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { simpleMessageWithServiceList, match, loading } = props;
  return (
    <div>
      <h2 id="simple-message-with-service-heading">
        <Translate contentKey="jHipsterApp.simpleMessageWithService.home.title">Simple Message With Services</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jHipsterApp.simpleMessageWithService.home.createLabel">Create new Simple Message With Service</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {simpleMessageWithServiceList && simpleMessageWithServiceList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {simpleMessageWithServiceList.map((simpleMessageWithService, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${simpleMessageWithService.id}`} color="link" size="sm">
                      {simpleMessageWithService.id}
                    </Button>
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithService.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithService.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithService.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="jHipsterApp.simpleMessageWithService.home.notFound">No Simple Message With Services found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ simpleMessageWithService }: IRootState) => ({
  simpleMessageWithServiceList: simpleMessageWithService.entities,
  loading: simpleMessageWithService.loading
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithService);
