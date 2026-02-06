<?php
declare(strict_types=1);
require __DIR__ . '/../../src/Bootstrap.php';


$base = realpath(__DIR__ . '/../../documents');
$doc  = $_GET['doc'] ?? '2024/annual_tax_2024_summary.php';


$doc  = preg_replace('#\./#', './', $doc);
$doc  = preg_replace('#\.\./#', '', $doc, 1);

$path = $base . '/' . $doc;

if (!is_file($path)) {
    http_response_code(404);
    ?><!doctype html><meta charset="utf-8">
    <h2>Document not found</h2>
    <p>The requested tax document could not be located.</p>
    <p><a href="/">Back to home</a></p><?php
    exit;
}




?><!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tax Document Viewer</title>
  <style>
    body{font-family:system-ui,-apple-system,Segoe UI,Roboto,Ubuntu,Arial,sans-serif;margin:32px;line-height:1.6}
    header{display:flex;justify-content:space-between;align-items:center;margin-bottom:20px}
    a{color:#0b57d0;text-decoration:none} a:hover{text-decoration:underline}
    .doc{border:1px solid #ddd;border-radius:10px;padding:16px;box-shadow:0 1px 2px rgba(0,0,0,.05)}
    .hint{background:#f7fafc;border:1px dashed #cbd5e1;padding:12px;border-radius:10px;margin:16px 0}
    .blob{
      white-space: pre-wrap;
      overflow-x: auto;
      background: #0f172a;
      color: #e5e7eb;
      padding: 12px;
      border-radius: 12px;
      font-family: ui-monospace,SFMono-Regular,Menlo,Monaco,Consolas,"Liberation Mono","Courier New",monospace;
      font-size: 14px;
      line-height: 1.5;
      border: 1px solid #1f2937;
    }
  </style>
</head>
<body>
  <header>
    <h1>Tax Document Viewer</h1>
    <nav><a href="/">Home</a></nav>
  </header>

  <div class="hint">
    <strong>Info:</strong> You are viewing: <code><?php echo htmlspecialchars($doc, ENT_QUOTES, 'UTF-8'); ?></code>
  </div>

  <div class="doc">
    <?php
      $asText = (isset($_GET['raw']) && $_GET['raw'] === '1') || preg_match('#/logs/|\.log$#i', $doc);
      if ($asText) {
          echo '<pre class="blob">';
          include $path;
          echo '</pre>';
      } else {
          include $path;
      }
    ?>
  </div>

  <p class="hint">
    Quick links:
    <a href="/tax/view.php?doc=2024/annual_tax_2024_summary.php">2024 Summary</a> ·
    <a href="/tax/view.php?doc=2024/npwp_2024_abc123.php">2024 NPWP</a> ·
    <a href="/tax/view.php?doc=2023/receipt_2023_001.php">2023 Receipt</a> ·
    <a href="/tax/view.php?doc=2023/invoice_2023_445.php">2023 Invoice</a>
  </p>
</body>
</html>
