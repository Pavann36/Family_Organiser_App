<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
}

header {
  text-align: center;
  padding: 20px;
  background-color: #f0f0f0;
}

h1 {
  font-size: 1.5em;
}

p {
  font-size: 0.8em;
  margin-bottom: 0;
}

main {
  padding: 20px;
}

h2 {
  margin-top: 20px;
}

.schedule-container {
  border: 1px solid #ddd;
  padding: 10px;
  margin-bottom: 10px;
}

.schedule {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 5px;
}

.schedule-details {
  flex-grow: 1; 
}

.schedule-buttons {
  display: flex;
  gap: 5px;
}
.logout{
  background-color: red;
  color: white;
  float: Right;
  padding: 5px 10px;
  border: none;
  text-decoration:none;
  border-radius: 3px;
  cursor: pointer;
}
.button {
  background-color: #4CAF50;
  color: white;
  text-decoration:none;
  padding: 5px 10px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

.add-button {
  background-color: #4CAF50; /* Green */
  color: white;
}

.edit-button {
  background-color: #FF9800; /* Orange */
  color: white;
}

.delete-button {
  background-color: #f44336; /* Red */
  color: white;
}

</style>

<body>
<header>
    <a href="Login.html" class="logout" >Logout</a>
    <h1>Family Organizer App</h1>
    <%String login=(String)session.getAttribute("logindetail"); %>
    <%out.print("<p>Welcome, "+ login+" &nbsp &nbsp</p>");%>
    <a href="stickynotes.html" class="button" style="float: left;">Sticky Notes</a>
    <a href="DelSchServlet.html" class="button" style="float: right;">Search Schedule</a>
  </header>
  <main>
    <h2>Upcoming Schedules &nbsp <a href="insertSch.html"><i class="fas fa-plus"></i></a>
    &nbsp <a href="updatesch.html"><i class="fas fa-edit"></i></a> &nbsp <a href="deleteSch.html"><i class="fas fa-trash"></i></a></h2>
    <div class="schedule-container" id="recent-schedules">Scheduling streamlines tasks and boosts productivity.
      </div>
          <div class="schedule-container" id="recent-schedules">Scheduling is a powerful tool that can be applied in various contexts to improve time management, organization, and productivity.
      </div>
      <form action="DisSServlet" >
      <button type="submit" class="button">View All Schedules </button>
      </form>
      <a href="DelActServlet.html" class="button" style="float: right;">Search Activity</a>
    <h2>Upcoming Activities &nbsp <a href="insertAct.html"><i class="fas fa-plus"></i></a> 
    &nbsp <a href="updateact.html"><i class="fas fa-edit"></i></a> &nbsp <a href="deleteAct.html"><i class="fas fa-trash"></i></a></h2>
    <div class="schedule-container" id="upcoming-schedules">Going on holiday together or getting together for a religious festival or a birthday
      </div>
          
      <form action="DisAServlet" >
      <button type="submit" class="button">View All Activities </button>
      </form>
  </main>
</body>
</html>