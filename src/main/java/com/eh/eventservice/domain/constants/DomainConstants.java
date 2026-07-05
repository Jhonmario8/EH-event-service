package com.eh.eventservice.domain.constants;

public class DomainConstants {
    public static final String KEY_ROLE_NAME = "role_name";
    public static final String KEY_SUBJECT ="sub";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String MSG_ONLY_ADMIN_CAN_CREATE_CATEGORY = "Only admin can create category";
    public static final String MSG_CATEGORY_NAME_ALREADY_EXIST ="Category name already exist";
    public static final String MSG_ONLY_ORGANIZER_CAN_CREATE_EVENT = "Only organizer can create event";
    public static final String MSG_CATEGORY_NOT_FOUND ="Category not found or inactive";
    public static final String MSG_EVENT_DATE_CANNOT_BE_BEFORE_CREATION_DATE = "Event date cannot be before creation date";
    public static final String MSG_EVENT_END_TIME_MUST_BE_AFTER_START_TIME = "Event end time must be after start time";
    public static final String KEY_USER_ID = "userId";
    public static final String MSG_ONLY_ADMIN_CAN_OPEN_EVENT = "Only admin can open event";
    public static final String MSG_EVENT_NOT_FOUND = "Event not found";
    public static final String MSG_ONLY_CREATED_EVENT_CAN_BE_OPENED = "Only created event can be opened";
}
