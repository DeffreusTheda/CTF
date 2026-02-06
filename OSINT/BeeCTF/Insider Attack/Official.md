## Solving Steps

Alright, so the challenge asks us to find the exact location of where the insider attacker fled off to along with their real name. We're only given a CV left behind by them.

### Step 1: Analyze the Given CV

---

Most of the information inside of the CV seems fake. Except for one: a GitHub account. Searching up the GitHub account will result in Batman Bin Suparman's GitHub account.

### Step 2: Find Information in the GitHub Account

---

Upon opening the GitHub account, we can see that there aren't a lot of useful information. In fact, there's even a red herring to throw you off. However, there's one feature in GitHub you can use to see the email of the person who edited a file.

All you need to do is add .patch to the end of the url of a commit. In this case, one of the commits Batman Bin Suparman made is

`https://github.com/BATMANSUPARMAN/Test_Repo/commit/cf4b3c92a4ffd67641c92cda9ad281958e7be12b`

We add .patch to the end of it like this:

`https://github.com/BATMANSUPARMAN/Test_Repo/commit/cf4b3c92a4ffd67641c92cda9ad281958e7be12b.patch`

The results should look something like this:

```From cf4b3c92a4ffd67641c92cda9ad281958e7be12b Mon Sep 17 00:00:00 2001
From: Batman Bin Suparman <darkknightsuparman@gmail.com>
Date: Tue, 2 Sep 2025 18:26:26 +0700
Subject: [PATCH] Initial commit

---
 README.md | 2 ++
 1 file changed, 2 insertions(+)
 create mode 100644 README.md

diff --git a/README.md b/README.md
new file mode 100644
index 0000000..d320eda
--- /dev/null
+++ b/README.md
@@ -0,0 +1,2 @@
+# Test_Repo
+Just a test repo, nothing much...
```

Unfortunately, the email doesn't contain his real name. At least we finally got this guy's email. But what do we want his email for?

### Step 3: Finding More Information Through the Email Address

---

There's one handy tool to use when conducting OSINT that you can use on gmail accounts. The tool is called EPIEOS. EPIEOS allows you to view further information regarding a gmail account. Most importantly, it can give us someone's Google Maps account which you can't really search for easily.

Since we have no other information about this guy's whereabouts, it's worth to give his Google Maps account a try. Who knows there might be some valueable information for us.

After inputting their gmail address in EPIEOS, it'll give us the link to their Google Maps account: https://www.google.com/maps/contrib/115384220253132838195

### Step 4: Finding Clues about Their Exact Location and Real Name

---

Turns out, the username on a Google Maps account is usually set to the person's real full name. In this case, Batman Bin Suparman's real name turns out to be `Elijah Davis`

Other than that, we can see that he has some Google Map reviews. Most of them located in Palermo, Italy. But remember, we need an exact location, not a broad one.

One of Elijah's Google Review is on this restaurant named "Da Spirito" with this following description:

```
What a way to enjoy true Sicilian cuisine! I went here for breakfast since the apartment I'm staying at for this holiday is just about 100 meters away from here (according to Google at least). I ordered the eggplant caponata or caponata di melanzane and it was great! Perfect way to start of my day in Palermo!
```

We have a massive clue. He's currently staying at an apartment that's just about 100 meters away from this restaurant (according to Google Maps at least).

Now, there are a few apartments near this restaurant but after measuring each of their distances according to Google Maps, we find that one of them is exactly 100 meters away. That apartment being "La Casetta Di Gra" with an address of `487R+8R Palermo, Metropolitan City of Palermo, Italy`

## Flag

<b>BEECTF{Elijah_Davis_487R+8R_Palermo_Italy}</b>

## What to Learn from this Challenge

We learned how to gain someone's email address through their GitHub commits, how to use the EPIEOS tool to get more information about a gmail address, and a bit of geolocation to pinpoint exact locations from clues.
