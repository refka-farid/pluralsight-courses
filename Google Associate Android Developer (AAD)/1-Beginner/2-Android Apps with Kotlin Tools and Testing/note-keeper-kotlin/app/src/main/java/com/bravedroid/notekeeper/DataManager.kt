package com.bravedroid.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    fun addNote(course: CourseInfo, noteTitle: String, noteText: String): Int {
        val note = NoteInfo(course, noteTitle, noteText)
        notes.add(note)
        return notes.lastIndex
    }

    fun findNote(course: CourseInfo, noteTitle: String, noteText: String): NoteInfo? {
        for (note in notes)
            if (course == note.course &&
                noteTitle == note.title &&
                noteText == note.text
            )
                return note
        return null
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android programing with intents")
        courses.set(course.courseId, course)

        course = CourseInfo("android_async", "Android async programming and services")
        courses.set(course.courseId, course)

        course = CourseInfo("Java Fundamentals : The Java Language", "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundementals: TheCore Platform")
        courses.set(course.courseId, course)
    }

     fun initializeNotes() {
        var note = NoteInfo(
            CourseInfo("android_intents", "Android programing with intents"),
            "android_intents",
            "Android programing with intents"
        )
        notes.add(note)

        note = NoteInfo(
            CourseInfo("android_async", "Android async programming and services"),
            "android_async",
            "Android async programming and services"
        )
        notes.add(note)

        note = NoteInfo(
            CourseInfo("Java Fundamentals : The Java Language", "java_lang"),
            "Java Fundamentals : The Java Language",
            "java_lang"
        )
        notes.add(note)

        note = NoteInfo(
            CourseInfo("java_core", "Java Fundementals: TheCore Platform"),
            "java_core",
            "Java Fundementals: TheCore Platform"
        )
        notes.add(note)
    }
}
