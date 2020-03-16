import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './simple-message-with-service-interface-dto-pagination.reducer';
import { ISimpleMessageWithServiceInterfaceDtoPagination } from 'app/shared/model/simple-message-with-service-interface-dto-pagination.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface ISimpleMessageWithServiceInterfaceDtoPaginationProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ url: string }> {}

export const SimpleMessageWithServiceInterfaceDtoPagination = (props: ISimpleMessageWithServiceInterfaceDtoPaginationProps) => {
  const [paginationState, setPaginationState] = useState(getSortState(props.location, ITEMS_PER_PAGE));

  const getAllEntities = () => {
    props.getEntities(paginationState.activePage - 1, paginationState.itemsPerPage, `${paginationState.sort},${paginationState.order}`);
  };

  useEffect(() => {
    getAllEntities();
  }, []);

  const sortEntities = () => {
    getAllEntities();
    props.history.push(
      `${props.location.pathname}?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`
    );
  };

  useEffect(() => {
    sortEntities();
  }, [paginationState.activePage, paginationState.order, paginationState.sort]);

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === 'asc' ? 'desc' : 'asc',
      sort: p
    });
  };

  const handlePagination = currentPage =>
    setPaginationState({
      ...paginationState,
      activePage: currentPage
    });

  const { simpleMessageWithServiceInterfaceDtoPaginationList, match, loading, totalItems } = props;
  return (
    <div>
      <h2 id="simple-message-with-service-interface-dto-pagination-heading">
        <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoPagination.home.title">
          Simple Message With Service Interface Dto Paginations
        </Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoPagination.home.createLabel">
            Create new Simple Message With Service Interface Dto Pagination
          </Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {simpleMessageWithServiceInterfaceDtoPaginationList && simpleMessageWithServiceInterfaceDtoPaginationList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {simpleMessageWithServiceInterfaceDtoPaginationList.map((simpleMessageWithServiceInterfaceDtoPagination, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterfaceDtoPagination.id}`} color="link" size="sm">
                      {simpleMessageWithServiceInterfaceDtoPagination.id}
                    </Button>
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${simpleMessageWithServiceInterfaceDtoPagination.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${simpleMessageWithServiceInterfaceDtoPagination.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${simpleMessageWithServiceInterfaceDtoPagination.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="danger"
                        size="sm"
                      >
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
              <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoPagination.home.notFound">
                No Simple Message With Service Interface Dto Paginations found
              </Translate>
            </div>
          )
        )}
      </div>
      <div
        className={
          simpleMessageWithServiceInterfaceDtoPaginationList && simpleMessageWithServiceInterfaceDtoPaginationList.length > 0
            ? ''
            : 'd-none'
        }
      >
        <Row className="justify-content-center">
          <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} i18nEnabled />
        </Row>
        <Row className="justify-content-center">
          <JhiPagination
            activePage={paginationState.activePage}
            onSelect={handlePagination}
            maxButtons={5}
            itemsPerPage={paginationState.itemsPerPage}
            totalItems={props.totalItems}
          />
        </Row>
      </div>
    </div>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterfaceDtoPagination }: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoPaginationList: simpleMessageWithServiceInterfaceDtoPagination.entities,
  loading: simpleMessageWithServiceInterfaceDtoPagination.loading,
  totalItems: simpleMessageWithServiceInterfaceDtoPagination.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoPagination);
