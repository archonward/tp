package seedu.address.model.milestone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MilestoneRecordTest {

    @Test
    public void constructor_nonCompletedStatusWithNonEmptyCompletedAt_throwsIllegalArgumentException() {
        CompletedAt completedAt = new CompletedAt("2026-03-24T1200H");

        assertThrows(IllegalArgumentException.class, () ->
                new MilestoneRecord(MilestoneStatus.NOT_STARTED, completedAt));
    }

    @Test
    public void constructor_completedStatusWithNonEmptyCompletedAt_success() {
        CompletedAt completedAt = new CompletedAt("2026-03-24T1200H");
        MilestoneRecord milestoneRecord = new MilestoneRecord(MilestoneStatus.COMPLETED, completedAt);

        assertEquals(MilestoneStatus.COMPLETED, milestoneRecord.getStatus());
        assertEquals(completedAt, milestoneRecord.getCompletedAt());
    }

    @Test
    public void constructor_nonCompletedStatusWithEmptyCompletedAt_success() {
        CompletedAt completedAt = new CompletedAt("");
        MilestoneRecord milestoneRecord = new MilestoneRecord(MilestoneStatus.IN_PROGRESS, completedAt);

        assertEquals(MilestoneStatus.IN_PROGRESS, milestoneRecord.getStatus());
        assertEquals(completedAt, milestoneRecord.getCompletedAt());
    }

    @Test
    public void equals() {
        MilestoneRecord firstRecord = new MilestoneRecord(
                MilestoneStatus.COMPLETED,
                new CompletedAt("2026-03-24T1200H"));

        MilestoneRecord sameRecord = new MilestoneRecord(
                MilestoneStatus.COMPLETED,
                new CompletedAt("2026-03-24T1200H"));

        MilestoneRecord differentStatusRecord = new MilestoneRecord(
                MilestoneStatus.EXEMPT,
                new CompletedAt(""));

        assertEquals(firstRecord, firstRecord);
        assertEquals(firstRecord, sameRecord);

        assertNotEquals(firstRecord, null);
        assertNotEquals(firstRecord, "not a MilestoneRecord");
        assertNotEquals(firstRecord, differentStatusRecord);
    }
}
