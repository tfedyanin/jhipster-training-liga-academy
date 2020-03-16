import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import SimpleMessageWithService from './simple-message-with-service';
import SimpleMessageWithServiceDetail from './simple-message-with-service-detail';
import SimpleMessageWithServiceUpdate from './simple-message-with-service-update';
import SimpleMessageWithServiceDeleteDialog from './simple-message-with-service-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={SimpleMessageWithServiceDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SimpleMessageWithServiceUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={SimpleMessageWithServiceUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SimpleMessageWithServiceDetail} />
      <ErrorBoundaryRoute path={match.url} component={SimpleMessageWithService} />
    </Switch>
  </>
);

export default Routes;
