<?php
namespace App;

final class Logger {
    private const APP_LOG = '/var/www/storage/logs/app.log';
    public static function write(string $line): void {
        $entry = '[' . date('H:i:s') . '] ' . $line . "\n";
        @file_put_contents(self::APP_LOG, $entry, FILE_APPEND | LOCK_EX);
    }
}
