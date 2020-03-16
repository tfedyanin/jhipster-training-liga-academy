import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import SimpleMessageWithServiceInterfaceDtoPagination from './simple-message-with-service-interface-dto-pagination';
import SimpleMessageWithServiceInterfaceDtoPaginationDetail from './simple-message-with-service-interface-dto-pagination-detail';
import SimpleMessageWithServiceInterfaceDtoPaginationUpdate from './simple-message-with-service-interface-dto-pagination-update';
import SimpleMessageWithServiceInterfaceDtoPaginationDeleteDialog from './simple-message-with-service-interface-dto-pagination-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={SimpleMessageWithServiceInterfaceDtoPaginationDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SimpleMessageWithServiceInterfaceDtoPaginationUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={SimpleMessageWithServiceInterfaceDtoPaginationUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SimpleMessageWithServiceInterfaceDtoPaginationDetail} />
      <ErrorBoundaryRoute path={match.url} component={SimpleMessageWithServiceInterfaceDtoPagination} />
    </Switch>
  </>
);

export default Routes;
