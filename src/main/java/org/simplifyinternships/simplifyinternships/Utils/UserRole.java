package org.simplifyinternships.simplifyinternships.Utils;

public enum UserRole {
    MENTOR{
        public Boolean isMentor(){
            return true;
        }
        public Boolean isApplicant(){
            return false;
        }
        @Override
        public String toString() {
            return "mentor";
        }
    },
    APPLICANT{
        public Boolean isMentor(){
            return false;
        }
        public Boolean isApplicant(){
            return true;
        }
        @Override
        public String toString() {
            return "applicant";
        }
    };
    public abstract String toString();
}
