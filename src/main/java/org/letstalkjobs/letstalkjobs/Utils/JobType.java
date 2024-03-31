package org.letstalkjobs.letstalkjobs.Utils;
/*
This enum is to categorise job opportunities into
different types ie Internship and attachments. It is a clean way to categorise
especially since the job types have almost similar properties
 */
public enum JobType {
    FULL_TIME{
        @Override
        public String toString() {
            return "Full time";
        }
    },
    ATTACHMENT{
        @Override
        public String toString() {
            return "Attachment";
        }
    },
    INTERNSHIP{
        @Override
        public String toString() {
            return "Internship";
        }
    };
    public abstract String toString();
}
