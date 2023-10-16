File buildLog = new File(basedir, 'build.log')
assert buildLog.exists()

assert buildLog.text.contains("BUILD SUCCESS")
assert new File(basedir, 'target').exists();
assert buildLog.text.contains("Hello! I am a component")