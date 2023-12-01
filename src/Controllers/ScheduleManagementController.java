package Controllers;

import java.util.Optional;

import Domain.Schedule.ScheduleManager;
import QueryParameters.QueryParameters;
import Repositories.Repository;

public class ScheduleManagementController {
    private Repository<ScheduleManager> repository;

    public ScheduleManagementController(Repository<ScheduleManager> repository) {
        this.repository = repository;
    }

    public String getSchedule(QueryParameters params) {
        Optional<ScheduleManager> searchResult = this.repository.fetchById(params.get("id"));

        if (!searchResult.isPresent()) {
            return "not found";
        }

        ScheduleManager manager = searchResult.get();

        return manager.getFormattedSchedule();
    }

}
