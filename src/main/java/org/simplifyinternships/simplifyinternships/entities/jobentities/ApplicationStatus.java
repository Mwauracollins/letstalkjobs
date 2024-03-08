package org.simplifyinternships.simplifyinternships.entities.jobentities;

public enum ApplicationStatus {
    PENDING{
        @Override
        public String toString() {
            return "Pending";
        }
    },
    ACCEPTED{
        @Override
        public String toString() {
            return "Accepted";
        }
    },
    REJECTED{
        @Override
        public String toString() {
            return "Rejected";
        }
    };
    public abstract String toString();
}
