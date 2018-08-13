<?php
// include file koneksi
require 'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST'){
    $message_body = $_POST['message_body'];
 	$message_sender = $_POST['message_sender'];
 	$message_to = $_POST['message_to'];
    $message_unread = $_POST['message_unread'];

    $query = "INSERT INTO tb_message (message_body,message_sender,message_to, message_unread) VALUES ('$message_body','$message_sender','$message_to','$message_unread')";

    $exeQuery = mysqli_query($conn, $query); 

            $response["msg"]=trim("Successfully uploaded.");
            $response["code"]=201;
            $response["status"]=true; 
            echo json_encode($response);


    /*echo ($exeQuery) ? json_encode(array('msg' => 'success', 'code' => 200,'status'=> true)) :  json_encode(array('msg' => 'not success', 'code' => 400,'status'=> false));*/
 }
 else
 {
     //echo json_encode(array('msg' => 'failed request to server', 'code' => 201,'status'=> false));
        $response["msg"]=trim("Forbidden.");
         $response["code"]=403;
         $response["status"]=false; 
            echo json_encode($response);
 }

 ?>