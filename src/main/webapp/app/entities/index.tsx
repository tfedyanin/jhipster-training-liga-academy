import React from 'react';
import { Switch } from 'react-router-dom';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import SimpleMessage from './simple-message';
import SimpleMessageWithService from './simple-message-with-service';
import SimpleMessageWithServiceInterface from './simple-message-with-service-interface';
import SimpleMessageWithServiceInterfaceDto from './simple-message-with-service-interface-dto';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}simple-message`} component={SimpleMessage} />
      <ErrorBoundaryRoute path={`${match.url}simple-message-with-service`} component={SimpleMessageWithService} />
      <ErrorBoundaryRoute path={`${match.url}simple-message-with-service-interface`} component={SimpleMessageWithServiceInterface} />
      <ErrorBoundaryRoute path={`${match.url}simple-message-with-service-interface-dto`} component={SimpleMessageWithServiceInterfaceDto} />
      {/* jhipster-needle-add-route-path - JHipster will add routes here */}
    </Switch>
  </div>
);

export default Routes;
