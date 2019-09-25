package com.bravedroid.notekeeper;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    static DataManager sDataManager;

    @BeforeClass
    public static void classSetUp() throws Exception {
        sDataManager = DataManager.getInstance();
    }

    //GIVEN
    @Rule
    public ActivityTestRule<NoteListActivity> mNoteListActivityRule =
            new ActivityTestRule<>(NoteListActivity.class);

    @Test
    public void createNewNote() throws InterruptedException {
        //GIVEN
        final CourseInfo course = sDataManager.getCourse("java_lang");
        final String noteTitle = "Test note title";
        final String noteText = "this is the body of our test note";
        //ViewInteraction fabNewNote = onView(withId(R.id.fab));
        //fabNewNote.perform((click()));
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.spinner_courses)).perform(click());
        //WHEN
        onData(allOf(instanceOf(CourseInfo.class), equalTo(course))).perform(click());
        // Thread.sleep(33000);
        onView(withId(R.id.text_note_title))
                .perform(typeText(noteTitle));
        onView(withId(R.id.text_note_text))
                .perform(typeText(noteText),
                        closeSoftKeyboard());
        pressBack();
        //THEN
        // TODO: 25/09/2019  
    }
}
