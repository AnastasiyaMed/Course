package by.pvt.medvedeva.education.command.client;

import by.pvt.medvedeva.education.command.*;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	REGISTR {
		{
			this.command = new RegistrCommand();
		}
	},
	SHOWCOURSES {
		{
			this.command = new GetCoursesListCommand();
		}
	},
	ADDSTUDENT {
		{
			this.command = new SetStudentRoleCommand();
		}
	},
	ADDTEACHER {
		{
			this.command = new SetTeacherRoleCommand();
		}
	},
	ADDCOURSE {
		{
			this.command = new NewCourseCommand();
		}
		},
	GOTOADDCOURSE {
		{
			this.command = new GoToNewCourseCommand();
		}
	},
	CHANGELOCALE {
			{
				this.command = new SetLocaleCommand();
		}

	};
	
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}