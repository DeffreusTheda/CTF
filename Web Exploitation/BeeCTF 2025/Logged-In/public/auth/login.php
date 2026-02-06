<?php
declare(strict_types=1);
require __DIR__ . '/../../src/Bootstrap.php';


use App\Logger;
$ua = $_SERVER['HTTP_USER_AGENT'] ?? '-';
Logger::write($ua);




http_response_code(401);
?><!doctype html><meta charset="utf-8">
<title>Login Failed</title>
<p>Invalid credentials. <br><a href="/">Back</a></p>
