package com.zaie.nunasurvei.model

object SoalanSurvei {
  val allSkills = listOfNotNull(
    "Internet Skills",
    "Software Skills",
    "Hardware Skills",
    "AI Skills",
    "VR Skills",
    "Cybersecurity Skills"
  )

  val internetSkills = listOf(
    "Do you think the ability to effectively use search engines is essential for employees in the manufacturing industry?",
    "Is it important for manufacturing employees to be proficient in using online collaboration tools (e.g., Google Workspace)?)",
    "Should all employees in the manufacturing sector be skilled in navigating and using cloud storage solutions?",
    "Do you believe that knowledge of online research methods is crucial for manufacturing employees?",
    "Is it necessary for employees to be familiar with internet-based communication tools (e.g., email, messaging apps)?"
  )

  val softwareSkills = listOf(
    "Do you think proficiency in Microsoft Office (Word, Excel, PowerPoint) is essential for manufacturing employees?",
    "Should employees in the manufacturing sector be skilled in using industry-specific software (e.g., CAD software)?",
    "Is it important for manufacturing employees to be able to troubleshoot basic software issues?",
    "Do you believe that understanding database management systems is crucial for manufacturing employees?",
    "Is it necessary for manufacturing employees to be proficient in using project management software (e.g., Microsoft Project, Asana)?"
  )

  val hardwareSkills = listOf(
    "Do you think it is essential for manufacturing employees to understand the basic components of a computer?",
    "Should employees in the manufacturing sector be able to perform basic hardware troubleshooting?",
    "Is it important for manufacturing employees to know how to set up and configure printers and other peripherals?",
    "Do you believe that knowledge of hardware maintenance is crucial for manufacturing employees?",
    "Is it necessary for employees to be familiar with the installation and configuration of computer hardware?"
  )

  val AiSkills = listOf(
    "Do you think understanding the basics of artificial intelligence is important for manufacturing employees?",
    "Should employees in the manufacturing sector be familiar with AI applications relevant to their field?",
    "Is it important for manufacturing employees to know how to analyze data using AI tools?",
    "Do you believe that knowledge of machine learning concepts is crucial for manufacturing employees?",
    "Is it necessary for manufacturing employees to understand the ethical implications of AI?"
  )

  val VrSkills = listOf(
    "Do you think familiarity with virtual reality technology is important for training purposes in the manufacturing industry?",
    "Should employees in the manufacturing sector be able to operate VR equipment?",
    "Is it important for manufacturing employees to understand the applications of VR in their field?",
    "Do you believe that knowledge of VR software is crucial for manufacturing employees?",
    "Is it necessary for manufacturing employees to be proficient in creating and manipulating VR content?"
  )

  val cybersecuritySkills = listOf(
    "Do you think knowledge of basic cybersecurity principles is essential for manufacturing employees?",
    "Should employees in the manufacturing sector be able to identify common cybersecurity threats (e.g., phishing, malware)?",
    "Is it important for manufacturing employees to know how to protect sensitive information?",
    "Do you believe that understanding network security is crucial for manufacturing employees?",
    "Is it necessary for manufacturing employees to be familiar with best practices for creating strong passwords?"
  )

  val skillMap = mapOf(
    "Internet Skills" to internetSkills,
    "Software Skills" to softwareSkills,
    "Hardware Skills" to hardwareSkills,
    "AI Skills" to AiSkills,
    "VR Skills" to VrSkills,
    "Cybersecurity Skills" to cybersecuritySkills
  )
}