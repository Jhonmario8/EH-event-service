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
    public static final String MSG_ONLY_ORGANIZER_CAN_UPDATE_EVENT = "Only organizer can update event";
    public static final String MSG_ONLY_ORGANIZER_CAN_UPDATE_OWN_EVENT = "Only organizer can update own event";
    public static final String MSG_ONLY_CREATED_OR_OPEN_EVENT_CAN_BE_UPDATED = "Only created or open event can be updated";
    public static final String MSG_EVENT_CAPACITY_CANNOT_BE_LESS_THAN_BOOKED_TICKETS = "Event capacity cannot be less than booked tickets";
    public static final String MSG_ONLY_CLIENT_CAN_CREATE_RESERVATION = "Only client can create reservation";
    public static final String MSG_EVENT_NOT_OPEN = "Only open event can be reserved";
    public static final String MSG_RESERVATION_ALREADY_EXISTS = "Reservation already exists for this event and user";
    public static final String MSG_RESERVATION_QUANTITY_INVALID = "Reservation quantity must be greater than zero and less than or equal to six";
    public static final String MSG_NOT_ENOUGH_TICKETS_AVAILABLE = "Not enough tickets available for this event";
    public static final String MSG_ONLY_CLIENT_CAN_CANCEL_RESERVATION = "Only client can cancel reservation";
    public static final String MSG_RESERVATION_NOT_FOUND = "Reservation not found";
    public static final String MSG_CANNOT_CANCEL_OTHER_CLIENT_RESERVATION = "Cannot cancel other client's reservation";
    public static final String MSG_RESERVATION_ALREADY_CANCELLED = "Reservation is already cancelled";
    public static final String MSG_CANNOT_CANCEL_RESERVATION_WITHIN_24_HOURS = "Cannot cancel reservation within 24 hours of the event start time";
    public static final Object MSG_RESERVATION_CANCELLED_SUCCESSFULLY = "Reservation cancelled successfully";
    public static final String MSG_ONLY_ADMIN_CAN_FINALIZE_EVENT = "Only admin can finalize event";
    public static final String MSG_ONLY_OPEN_OR_SOLD_OUT_EVENT_CAN_BE_FINALIZED = "Only open or sold out event can be finalized";
    public static final String MSG_ONLY_OPEN_OR_CREATED_EVENT_CAN_BE_CANCELLED = "Only open or created event can be cancelled";
    public static final String MSG_ONLY_CLIENT_CAN_VIEW_RESERVATIONS = "Only client can view reservations";
}
