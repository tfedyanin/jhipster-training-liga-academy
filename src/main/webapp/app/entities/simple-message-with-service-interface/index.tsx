import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import SimpleMessageWithServiceInterface from './simple-message-with-service-interface';
import SimpleMessageWithServiceInterfaceDetail from './simple-message-with-service-interface-detail';
import SimpleMessageWithServiceInterfaceUpdate from './simple-message-with-service-interface-update';
import SimpleMessageWithServiceInterfaceDeleteDialog from './simple-message-with-service-interface-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={SimpleMessageWithServiceInterfaceDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SimpleMessageWithServiceInterfaceUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={SimpleMessageWithServiceInterfaceUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SimpleMessageWithServiceInterfaceDetail} />
      <ErrorBoundaryRoute path={match.url} component={SimpleMessageWithServiceInterface} />
    </Switch>
  </>
);

export default Routes;
