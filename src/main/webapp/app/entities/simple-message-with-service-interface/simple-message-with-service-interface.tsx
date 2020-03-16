import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './simple-message-with-service-interface.reducer';
import { ISimpleMessageWithServiceInterface } from 'app/shared/model/simple-message-with-service-interface.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISimpleMessageWithServiceInterfaceProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const SimpleMessageWithServiceInterface = (props: ISimpleMessageWithServiceInterfaceProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { simpleMessageWithServiceInterfaceList, match, loading } = props;
  return (
    <div>
      <h2 id="simple-message-with-service-interface-heading">
        <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterface.home.title">Simple Message With Service Interfaces</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterface.home.createLabel">
            Create new Simple Message With Service Interface
          </Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {simpleMessageWithServiceInterfaceList && simpleMessageWithServiceInterfaceList.length > 0 ? (
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
              {simpleMessageWithServiceInterfaceList.map((simpleMessageWithServiceInterface, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterface.id}`} color="link" size="sm">
                      {simpleMessageWithServiceInterface.id}
                    </Button>
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterface.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterface.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterface.id}/delete`} color="danger" size="sm">
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
              <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterface.home.notFound">
                No Simple Message With Service Interfaces found
              </Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterface }: IRootState) => ({
  simpleMessageWithServiceInterfaceList: simpleMessageWithServiceInterface.entities,
  loading: simpleMessageWithServiceInterface.loading
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterface);
