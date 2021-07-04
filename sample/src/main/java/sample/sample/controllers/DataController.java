package sample.sample.controllers;

import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.controllers.AbstractDataController;
import sample.sample.configuration.Configuration;
import sample.sample.services.DataService;
import sample.sample.types.Example;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class DataController extends AbstractDataController {
    @Inject
    private DataService dataService;

    @Override
    public ObjectDataResponse delete(ObjectDataRequest objectDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse load(ObjectDataRequest objectDataRequest) throws Exception {
        Configuration configurationValues = this.parseConfigurationValues(objectDataRequest, Configuration.class);

        String objectDeveloperName = objectDataRequest.getObjectDataType().getDeveloperName();

        switch (objectDeveloperName) {
            case Example.NAME:
                return this.dataService.loadExamples(configurationValues);
        }

        return new ObjectDataResponse();
    }

    @Override
    public ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception {
        Configuration configurationValues = this.parseConfigurationValues(objectDataRequest, Configuration.class);

        String objectDeveloperName = objectDataRequest.getObjectDataType().getDeveloperName();

        switch (objectDeveloperName) {
            case Example.NAME:
                return this.dataService.saveExample(configurationValues, objectDataRequest.getObjectData());
        }

        return new ObjectDataResponse();
    }
}
