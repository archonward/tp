package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedGroup.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.group.AssignmentList;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.group.StudentList;
import seedu.address.model.person.StudentId;

public class JsonAdaptedGroupTest {

    private static final ArrayList<String> VALID_STUDENTLIST =
            new ArrayList<>() {{
                    add("S1");
                    add("S2");
            }};
    private static final ArrayList<String> VALID_ASSIGNMENTLIST =
            new ArrayList<>() {{
                    add("A1");
                    add("A2");
            }};

    @Test
    public void toModelType_validGroupDetails_returnsGroup() throws Exception {
        StudentList list = new StudentList();
        list.addStudent(new StudentId("S1"));
        Group testGroup = new Group(new GroupName("CS"), list, new AssignmentList());
        JsonAdaptedGroup group = new JsonAdaptedGroup(testGroup);
        assertEquals(testGroup, group.toModelType());
    }

    @Test
    public void toModelType_nullGroupName_throwsIllegalValueException() {
        JsonAdaptedGroup group =
                new JsonAdaptedGroup(null, VALID_STUDENTLIST, VALID_ASSIGNMENTLIST);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT,
                GroupName.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, group::toModelType);
    }
}
