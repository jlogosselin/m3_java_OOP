package ExerciseJ_ClassRoster.com.sg.classroster.dao;

/*
The purpose of this exception is to allow us to hide
the underlying implementation exceptions so that
we don't leak implementation details from our DAO.

This is common practice when creating specific exceptions
for any application.

By extending Exception, we inherit all of the capabilities
of Exception and then can add any special features that we
wish to add.

In our case, we won't add any new features — we want our
exception to act just like Exception but extending Exception
allows us to translate and/or wrap any implementation-specific
exception that can get thrown, which is exactly the feature
we're interested in.

Remember that when we extend Exception, our new exception
will be a checked exception (see class icon in PROJECT).

Notice that are implementing CONSTRUCTOR OVERLOADING.

We will use the first constructor in cases where something
is wrong in our application but it isn't caused by another exception.
For example, maybe our application has some validation rules for
student data input and one of the fields doesn't pass validation.
In that case, we could throw a new ClassRosterDaoException with
a message describing the problem.
We'll look at these cases in the next section of the course.

We will use the second constructor in cases where something
is wrong in our application that is caused by another exception
in the underlying implementation.
In these cases, we catch the implementation-specific exception
(for example FileNotFoundException).
In the catch block, we would create a new ClassRosterDaoException
and pass in a new message and the exception that caused the
original problem, and then we throw the newly-created ClassRosterDaoException.
We have effectively wrapped the original exception with our
application-specific exception.
 */

public class ClassRosterDaoException extends Exception{

    public ClassRosterDaoException(String message) {
        super(message);
    }

    public ClassRosterDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
