<?php

spl_autoload_register(function ($class) {
    if (str_starts_with($class, 'App\\')) {
        $path = __DIR__ . '/' . str_replace(['App\\', '\\'], ['', '/'], $class) . '.php';
        if (is_file($path)) require $path;
    }
});


@mkdir('/var/www/storage/logs', 0775, true);
if (!file_exists('/var/www/storage/logs/app.log')) @touch('/var/www/storage/logs/app.log');

