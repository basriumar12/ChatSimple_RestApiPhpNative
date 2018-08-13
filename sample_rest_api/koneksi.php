<?php
// mengkoneksikan ke database
$server = "localhost";
$server_username = "root";
$server_password = "";
$database_name =  "chat";

$conn = new Mysqli($server, $server_username, $server_password, $database_name);
