import React, { useState, useEffect } from 'react';
import InfiniteScroll from 'react-infinite-scroller';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, getSortState, IPaginationBaseState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities, reset } from './simple-message-with-service-interface-dto-infinity-scroll-filtering.reducer';
import { ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering } from 'app/shared/model/simple-message-with-service-interface-dto-infinity-scroll-filtering.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface ISimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringProps
  extends StateProps,
    DispatchProps,
    RouteComponentProps<{ url: string }> {}

export const SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = (
  props: ISimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringProps
) => {
  const [paginationState, setPaginationState] = useState(getSortState(props.location, ITEMS_PER_PAGE));
  const [sorting, setSorting] = useState(false);

  const getAllEntities = () => {
    props.getEntities(paginationState.activePage - 1, paginationState.itemsPerPage, `${paginationState.sort},${paginationState.order}`);
  };

  const resetAll = () => {
    props.reset();
    setPaginationState({
      ...paginationState,
      activePage: 1
    });
  };

  useEffect(() => {
    resetAll();
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      getAllEntities();
    }
  });

  useEffect(() => {
    getAllEntities();
  }, [paginationState.activePage]);

  const handleLoadMore = () => {
    if (window.pageYOffset > 0) {
      setPaginationState({
        ...paginationState,
        activePage: paginationState.activePage + 1
      });
    }
  };

  useEffect(() => {
    if (sorting) {
      getAllEntities();
      setSorting(false);
    }
  }, [sorting]);

  const sort = p => () => {
    props.reset();
    setPaginationState({
      ...paginationState,
      activePage: 1,
      order: paginationState.order === 'asc' ? 'desc' : 'asc',
      sort: p
    });
    setSorting(true);
  };

  const { simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList, match, loading } = props;
  return (
    <div>
      <h2 id="simple-message-with-service-interface-dto-infinity-scroll-filtering-heading">
        <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.home.title">
          Simple Message With Service Interface Dto Infinity Scroll Filterings
        </Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.home.createLabel">
            Create new Simple Message With Service Interface Dto Infinity Scroll Filtering
          </Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        <InfiniteScroll
          pageStart={paginationState.activePage}
          loadMore={handleLoadMore}
          hasMore={paginationState.activePage - 1 < props.links.next}
          loader={<div className="loader">Loading ...</div>}
          threshold={0}
          initialLoad={false}
        >
          {simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList &&
          simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList.length > 0 ? (
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
                {simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList.map(
                  (simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering, i) => (
                    <tr key={`entity-${i}`}>
                      <td>
                        <Button
                          tag={Link}
                          to={`${match.url}/${simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.id}`}
                          color="link"
                          size="sm"
                        >
                          {simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.id}
                        </Button>
                      </td>
                      <td className="text-right">
                        <div className="btn-group flex-btn-group-container">
                          <Button
                            tag={Link}
                            to={`${match.url}/${simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.id}`}
                            color="info"
                            size="sm"
                          >
                            <FontAwesomeIcon icon="eye" />{' '}
                            <span className="d-none d-md-inline">
                              <Translate contentKey="entity.action.view">View</Translate>
                            </span>
                          </Button>
                          <Button
                            tag={Link}
                            to={`${match.url}/${simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.id}/edit`}
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
                            to={`${match.url}/${simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.id}/delete`}
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
                  )
                )}
              </tbody>
            </Table>
          ) : (
            !loading && (
              <div className="alert alert-warning">
                <Translate contentKey="jHipsterApp.simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.home.notFound">
                  No Simple Message With Service Interface Dto Infinity Scroll Filterings found
                </Translate>
              </div>
            )
          )}
        </InfiniteScroll>
      </div>
    </div>
  );
};

const mapStateToProps = ({ simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering }: IRootState) => ({
  simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList: simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.entities,
  loading: simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.loading,
  totalItems: simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.totalItems,
  links: simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.links,
  entity: simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.entity,
  updateSuccess: simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.updateSuccess
});

const mapDispatchToProps = {
  getEntities,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);
