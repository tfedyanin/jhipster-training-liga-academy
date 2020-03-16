import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import SimpleMessageWithServiceInterfaceDto from './simple-message-with-service-interface-dto';
import SimpleMessageWithServiceInterfaceDtoDetail from './simple-message-with-service-interface-dto-detail';
import SimpleMessageWithServiceInterfaceDtoUpdate from './simple-message-with-service-interface-dto-update';
import SimpleMessageWithServiceInterfaceDtoDeleteDialog from './simple-message-with-service-interface-dto-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={SimpleMessageWithServiceInterfaceDtoDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SimpleMessageWithServiceInterfaceDtoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={SimpleMessageWithServiceInterfaceDtoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SimpleMessageWithServiceInterfaceDtoDetail} />
      <ErrorBoundaryRoute path={match.url} component={SimpleMessageWithServiceInterfaceDto} />
    </Switch>
  </>
);

export default Routes;
