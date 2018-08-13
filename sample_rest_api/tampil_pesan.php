<?php
// include file koneksi
require 'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST'){

 	$message_sender = $_POST['message_sender'];
 	$message_to = $_POST['message_to'];
	$message_sender1 = $_POST['message_sender1'];
 	$message_to1 = $_POST['message_to1'];

 	 $query = mysqli_query($conn,"SELECT * FROM tb_message WHERE message_sender='$message_sender' AND message_to='$message_to' OR
 	 message_sender='$message_sender1' AND message_to='$message_to1' ");
 	   $response=array();
        $count = mysqli_num_rows($query);
          if($count>0) {
            $response["message"]=array();
            
            while ($row=mysqli_fetch_array($query)){

                $data=array();
                $data["message_id"]=$row["message_id"];
                $data["message_body"]=$row["message_body"];
                $data["message_sender"]=$row["message_sender"];
                $data["message_to"]=$row["message_to"];
                $data["message_unread"]=$row["message_unread"];
                $data["message_post_date"]=$row["message_post_date"];
                
                $response["msg"]=trim("success.");
                $response["code"]=200;
                $response["status"]=true;
                array_push($response["message"],$data);
            }

            echo json_encode($response);

        } else {

            $response["msg"]=trim("not succes");
            $response["code"]=400;
            $response["status"]=false; 
            echo json_encode($response);

        }

} else {

    		$response["msg"]=trim("failed get data");
            $response["code"]=401;
            $response["status"]=false; 
    echo json_encode($response);
}
