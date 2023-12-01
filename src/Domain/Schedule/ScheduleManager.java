package Domain.Schedule;

import Repositories.Entity;

public class ScheduleManager implements Entity {

    private String semesterId;
    private String[] schedule;

    public static final int DAYS_IN_WEEK = Block.values().length;

    public ScheduleManager(String semesterId) {
        this.semesterId = semesterId;
        this.schedule = new String[DAYS_IN_WEEK];
    }

    public String getSemesterId() {
        return semesterId;
    }

    public String[] getSchedule() {
        return schedule;
    }

    public String getCourseForBlock(Block block) {
        int indexForBlock = getIndexForBlock(block);
        if (indexForBlock != -1) {
            return schedule[indexForBlock];
        } else {
            throw new IllegalArgumentException("Invalid block");
        }
    }

    public void removeCourseSectionFromSchedule(String courseSectionId) {
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] != null && schedule[i].equals(courseSectionId)) {
                schedule[i] = null;
                System.out.println("Removed " + courseSectionId + " from the current schedule.");
                return;
            }
        }
        System.out.println(courseSectionId + " is not scheduled.");
    }

    public boolean isBlockAvailable(Block block) {
        int indexForBlock = getIndexForBlock(block);
        if (indexForBlock != -1) {
            return schedule[indexForBlock] == null;
        }
        return false;
    }

    public String getFormattedSchedule() {
        StringBuilder formattedSchedule = new StringBuilder();
        formattedSchedule.append("Schedule for semester: ").append(semesterId).append("\n");

        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            formattedSchedule.append(Block.values()[i]).append(": ")
                    .append(schedule[i] != null ? schedule[i] : "Available").append("\n");
        }

        return formattedSchedule.toString();
    }

    public void printSchedule() {
        System.out.println(getFormattedSchedule());
    }

    public void scheduleCourseSection(String courseSectionId, Block block) {
        int indexForBlock = getIndexForBlock(block);
        if (indexForBlock != -1) {
            if (isBlockAvailable(block)) {
                schedule[indexForBlock] = courseSectionId;
                System.out.println("Scheduled " + courseSectionId + " on " + block);
            } else {
                System.out.println("Block " + block + " is already scheduled.");
            }
        } else {
            System.out.println("Invalid block");
        }
    }

    private int getIndexForBlock(Block block) {
        if (block == Block.M) {
            return 0;
        } else if (block == Block.T) {
            return 1;
        } else if (block == Block.W) {
            return 2;
        } else if (block == Block.R) {
            return 3;
        } else if (block == Block.F) {
            return 4;
        }
        return -1;
    }

    public String getId() {
        return this.semesterId;
    }
}
