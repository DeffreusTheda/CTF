<?php
declare(strict_types=1);
require __DIR__ . '/../src/Bootstrap.php';



?><!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tax Portal</title>
  <style>
    body{font-family:system-ui,-apple-system,Segoe UI,Roboto,Ubuntu,Arial,sans-serif;margin:40px;line-height:1.5}
    header{margin-bottom:24px}
    a{color:#0b57d0;text-decoration:none} a:hover{text-decoration:underline}
    .card{border:1px solid #ddd;border-radius:10px;padding:16px;margin:10px 0;box-shadow:0 1px 2px rgba(0,0,0,.05)}
    .grid{display:grid;grid-template-columns:repeat(auto-fit,minmax(260px,1fr));gap:16px}
  </style>
</head>
<body>
  <header>
    <h1>Tax Portal</h1>
    <p>Welcome to the tax portal. View past documents or attempt to sign in.</p>
  </header>

  <section class="grid">
    <div class="card">
      <h3>Tax Documents</h3>
      <ul>
        <li><a href="/tax/view.php?doc=2024/annual_tax_2024_summary.php">2024 Annual Tax Summary</a></li>
        <li><a href="/tax/view.php?doc=2024/npwp_2024_abc123.php">2024 NPWP Record</a></li>
        <li><a href="/tax/view.php?doc=2023/receipt_2023_001.php">2023 Receipt #001</a></li>
        <li><a href="/tax/view.php?doc=2023/invoice_2023_445.php">2023 Invoice #445</a></li>
      </ul>
    </div>
    <div class="card">
      <h3>Log In</h3>
      <form action="/auth/login.php" method="post">
        <label>Username</label><br>
        <input name="username" placeholder="user@example.com"><br><br>
        <label>Password</label><br>
        <input name="password" type="password" placeholder="********"><br><br>
        <button type="submit">Sign in</button>
      </form>
      <p><small>This demo intentionally always fails sign-in (for logging).</small></p>
    </div>
  </section>
</body>
</html>
