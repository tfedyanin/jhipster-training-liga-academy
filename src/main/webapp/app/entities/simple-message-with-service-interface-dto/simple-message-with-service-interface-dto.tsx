import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './simple-message-with-service-interface-dto.reducer';
import { ISimpleMessageWithServiceInterfaceDto } from 'app/shared/model/simple-message-with-service-interface-dto.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISimpleMessageWithServiceInterfaceDtoProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const SimpleMessageWithServiceInterfaceDto = (props: ISimpleMessageWithServiceInterfaceDtoProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { simpleMessageWithServiceInterfaceDtoList, match, loading } = props;
  return (
    <div>
      <h2 id="simple-message-with-service-interface-dto-heading">
        <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDto.home.title">
          Simple Message With Service Interface Dtos
        </Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDto.home.createLabel">
            Create new Simple Message With Service Interface Dto
          </Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {simpleMessageWithServiceInterfaceDtoList && simpleMessageWithServiceInterfaceDtoList.length > 0 ? (
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
              {simpleMessageWithServiceInterfaceDtoList.map((simpleMessageWithServiceInterfaceDto, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterfaceDto.id}`} color="link" size="sm">
                      {simpleMessageWithServiceInterfaceDto.id}
                    </Button>
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterfaceDto.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterfaceDto.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterfaceDto.id}/delete`} color="danger" size="sm">
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
              <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDto.home.notFound">
                No Simple Message With Service Interface Dtos found
              </Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterfaceDto }: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoList: simpleMessageWithServiceInterfaceDto.entities,
  loading: simpleMessageWithServiceInterfaceDto.loading
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDto);
