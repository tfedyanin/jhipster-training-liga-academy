import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import SimpleMessage from './simple-message';
import SimpleMessageDetail from './simple-message-detail';
import SimpleMessageUpdate from './simple-message-update';
import SimpleMessageDeleteDialog from './simple-message-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={SimpleMessageDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SimpleMessageUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={SimpleMessageUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SimpleMessageDetail} />
      <ErrorBoundaryRoute path={match.url} component={SimpleMessage} />
    </Switch>
  </>
);

export default Routes;
